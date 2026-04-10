
    class Driver {
        String driverId;
        String name;
        RouteLinkedList<Checkpoint> routeHistory;

        public Driver(String id, String n) {
            driverId = id;
            name = n;
            routeHistory = new RouteLinkedList<>();
        }

        public void printSummary() {
            System.out.println("Driver: " + driverId + " - " + name);
            System.out.println("Route Summary:");
            routeHistory.printRoute();
            double dist = routeHistory.computeTotalDistance();
            double pen = routeHistory.computeTotalPenalty();
            double score = dist - pen;
            System.out.println("Total Distance: " + dist + " km");
            System.out.println("Total Penalty: " + pen);
            System.out.println("Route Score: " + score);
            if (routeHistory.isConsistent()) {
                System.out.println("Critical Route Check: All required checkpoints present");
            } else {
                System.out.println("Critical Route Check: Missing critical checkpoints");
            }
        }
    }
