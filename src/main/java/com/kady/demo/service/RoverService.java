package com.kady.demo.service;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.kady.demo.model.Direction;
import com.kady.demo.model.Position;
import com.kady.demo.model.Rover;
import com.kady.demo.model.Status;

@Service
public class RoverService {

	public static final String MOTION = "FB";
	public static final String TURNING = "LR";
	private List<Position> obstacles;

	@PostConstruct
	public void init() {
		obstacles = Arrays.asList(new Position(1, 4), new Position(3, 5), new Position(7, 4));
	}

	public Rover process(String moves) {
		Rover r = new Rover(Position.builder().x(4).y(2).build(), Direction.EAST, Status.MOVING);
		for (String c : Arrays.asList(moves.split(""))) {
			if (MOTION.contains(c)) {
				if (!move(r, c)) {
					r.setStatus(Status.STOPPED);
					return r;
				}
			} else if (TURNING.contains(c)) {
				turn(r, c);
			} else {
				throw new IllegalArgumentException("input must only contain F , L ,B , R");
			}
		}
		r.setStatus(Status.FINSHED);
		return r;
	}

	public void turn(Rover r, String s) {
		boolean left = s.equals("L");
		if (left)
			turnLeft(r);
		else
			turnRigth(r);
	}

	public void turnRigth(Rover r) {
		r.setDirection(r.getDirection().right());
	}

	public void turnLeft(Rover r) {
		r.setDirection(r.getDirection().left());
	}

	public boolean move(Rover r, String forward) {
		int x = r.getPosition().getX();
		int y = r.getPosition().getY();
		Position p = r.getPosition();
		switch (r.getDirection().ordinal()) {
		case 0:
			p.setX(forward.equals("F") ? x + 1 : x - 1);
			break;
		case 1:
			p.setY(forward.equals("F") ? y + 1 : y - 1);
			break;
		case 2:
			p.setY(forward.equals("F") ? y - 1 : y + 1);
			break;
		case 3:
			p.setX(forward.equals("F") ? x - 1 : x + 1);
			break;
		default:
			break;
		}
		if (obstacles.contains(p)) {
			r.setPosition(new Position(x, y));
			return false;
		}
		r.setPosition(p);
		return true;
	}
}
