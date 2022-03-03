package com.kady.demo.model;

public enum Direction {

	EAST {
		@Override
		public Direction left() {
			return NORTH;
		}

		public Direction right() {
			return SOUTH;
		}
	},
	NORTH {
		@Override
		public Direction left() {
			return WEST;
		}

		public Direction right() {
			return EAST;
		}
	},
	SOUTH {
		@Override
		public Direction left() {
			return EAST;
		}

		public Direction right() {
			return WEST;
		}
	},
	WEST {
		@Override
		public Direction left() {
			return SOUTH;
		}

		public Direction right() {
			return NORTH;
		}
	};

	public abstract Direction left();

	public abstract Direction right();
}
