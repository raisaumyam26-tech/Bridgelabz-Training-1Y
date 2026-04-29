package com.gla.logistics;

// ============================================================
// GENERIC SINGLY LINKED LIST
// T must be a Checkpoint or any of its subclasses
// ============================================================

public class RouteLinkedList<T extends Checkpoint> {

    // ---- Node: each node holds one checkpoint and a pointer to next ----
    private class Node {
        T data;       // The actual checkpoint object stored in this node
        Node next;    // Pointer to the next node

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // ---- Fields ----
    private Node head;  // First node of the list
    private int size;   // Number of checkpoints in the list

    // Constructor
    public RouteLinkedList() {
        head = null;
        size = 0;
    }

    // ============================================================
    // ADD: add a new checkpoint at the end of the route
    // ============================================================
    public void addCheckpoint(T checkpoint) {
        Node newNode = new Node(checkpoint);

        if (head == null) {
            // List is empty - new node becomes the head
            head = newNode;
        } else {
            // Traverse to the last node
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode; // Attach new node at the end
        }
        size++;
        System.out.println("Checkpoint [" + checkpoint.id + "] added successfully.");
    }

    // ============================================================
    // REMOVE: remove a checkpoint by its ID
    // ============================================================
    public boolean removeCheckpoint(String checkpointId) {
        if (head == null) {
            System.out.println("Route is empty. Nothing to remove.");
            return false;
        }

        // Special case: if the head itself is the one to remove
        if (head.data.id.equals(checkpointId)) {
            head = head.next;
            size--;
            System.out.println("Checkpoint [" + checkpointId + "] removed.");
            return true;
        }

        // Traverse to find the node just before the one to delete
        Node current = head;
        while (current.next != null) {
            if (current.next.data.id.equals(checkpointId)) {
                current.next = current.next.next; // Skip over the node to delete
                size--;
                System.out.println("Checkpoint [" + checkpointId + "] removed.");
                return true;
            }
            current = current.next;
        }

        System.out.println("Checkpoint [" + checkpointId + "] not found.");
        return false;
    }

    // ============================================================
    // FIND: search for a checkpoint by ID and return it
    // ============================================================
    public T findCheckpoint(String checkpointId) {
        Node current = head;
        while (current != null) {
            if (current.data.id.equals(checkpointId)) {
                return current.data; // Found!
            }
            current = current.next;
        }
        return null; // Not found
    }

    // ============================================================
    // COMPUTE TOTAL DISTANCE of all checkpoints in the route
    // ============================================================
    public double computeTotalDistance() {
        double total = 0.0;
        Node current = head;
        while (current != null) {
            total += current.data.distance;
            current = current.next;
        }
        return total;
    }

    // ============================================================
    // COMPUTE TOTAL PENALTY across all checkpoints
    // ============================================================
    public double computeTotalPenalty() {
        double total = 0.0;
        Node current = head;
        while (current != null) {
            total += current.data.Penality();
            current = current.next;
        }
        return total;
    }

    // ============================================================
    // COMPUTE ROUTE SCORE = totalDistance - totalPenalty
    // ============================================================
    public double computeRouteScore() {
        return computeTotalDistance() - computeTotalPenalty();
    }

    // ============================================================
    // CONSISTENCY CHECK:
    // Returns true only if at least one Delivery AND one Fuel checkpoint exists
    // ============================================================
    public boolean isConsistent() {
        boolean hasDelivery = false;
        boolean hasFuel = false;

        Node current = head;
        while (current != null) {
            if (current.data instanceof Delivery) {
                hasDelivery = true;
            }
            if (current.data instanceof FuelCheckpoint) {
                hasFuel = true;
            }
            current = current.next;
        }

        return hasDelivery && hasFuel; // Both must be present
    }

    // ============================================================
    // PRINT ROUTE: display all checkpoints with details
    // ============================================================
    public void printRoute() {
        if (head == null) {
            System.out.println("  Route is empty.");
            return;
        }

        System.out.println("  ---------------------------------------------------------------");
        System.out.printf("  %-6s %-15s %-12s %-8s %-8s %-8s %-8s%n",
                "ID", "Location", "Type", "Dist(km)", "Exp(min)", "Act(min)", "Penalty");
        System.out.println("  ---------------------------------------------------------------");

        Node current = head;
        while (current != null) {
            T cp = current.data;
            System.out.printf("  %-6s %-15s %-12s %-8.1f %-8d %-8d %-8.1f%n",
                    cp.id,
                    cp.location,
                    cp.getType(),
                    cp.distance,
                    cp.expected_time,
                    cp.actual_time,
                    cp.Penality());
            current = current.next;
        }
        System.out.println("  ---------------------------------------------------------------");
        System.out.printf("  Total Distance : %.1f km%n", computeTotalDistance());
        System.out.printf("  Total Penalty  : %.1f%n", computeTotalPenalty());
        System.out.printf("  Route Score    : %.1f%n", computeRouteScore());
        System.out.println("  Consistent     : " + (isConsistent() ? "YES" : "NO - Missing Delivery or Fuel checkpoint!"));
        System.out.println("  ---------------------------------------------------------------");
    }

    // Returns the number of checkpoints in the route
    public int getSize() {
        return size;
    }
}
