package com.github.douglashiura.two.d;

import java.util.Arrays;
import java.util.List;

public enum Directions {

	SUN {
		@Override
		public List<Directions> possibilities() {
			return Arrays.asList(ABOVE, SUN, LEFT);
		}
	},
	ABOVE {
		@Override
		public List<Directions> oposities() {
			return Arrays.asList(CHIEN, BELOW, KEN);
		}

		@Override
		public List<Directions> possibilities() {
			return Arrays.asList(SUN, ABOVE, KUN);
		}
	},
	KUN {
		@Override
		public List<Directions> possibilities() {
			return Arrays.asList(ABOVE, KUN, RIGHT);
		}
	},
	RIGHT {
		@Override
		public List<Directions> oposities() {
			return Arrays.asList(SUN, LEFT, KEN);
		}

		@Override
		public List<Directions> possibilities() {
			return Arrays.asList(KUN, RIGHT, CHIEN);
		}
	},
	// sun | above | kun
	// left | this | right
	// ken | below | chien
	CHIEN {
		@Override
		public List<Directions> possibilities() {
			return Arrays.asList(RIGHT, CHIEN, BELOW);
		}
	},
	BELOW {
		@Override
		public List<Directions> oposities() {
			return Arrays.asList(SUN, ABOVE, KUN);
		}

		@Override
		public List<Directions> possibilities() {
			return Arrays.asList(CHIEN, BELOW, KEN);
		}
	},
	KEN {
		@Override
		public List<Directions> possibilities() {
			return Arrays.asList(LEFT, KEN, BELOW);
		}
	},
	LEFT {
		@Override
		public List<Directions> oposities() {
			return Arrays.asList(KUN, RIGHT, CHIEN);
		}

		@Override
		public List<Directions> possibilities() {
			return Arrays.asList(SUN, LEFT, KEN);
		}
	};

	public List<Directions> oposities() {
		throw new RuntimeException();
	}

	public abstract List<Directions> possibilities();

}
