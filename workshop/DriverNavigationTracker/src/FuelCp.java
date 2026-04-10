
    class FuelCp extends Checkpoint {
        public FuelCp(String id, String loc, double dist, double exp, double act) {
            super(id, loc, dist, exp, act);
        }

        public boolean isCritical() {
            return true;
        }

        public String getType() {
            return "FuelCheckpoint";
        }

        public double calculatePenalty() {
            if (isDelayed()) {
                return 10.0;
            }
            return 0.0;
        }
    }
