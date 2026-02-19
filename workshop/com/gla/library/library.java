package com.gla.library;

public class library {
    private int Quantity;
    private Admin admin;
    public LibraryRepository libraryRepository = new LibraryRepository();

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
