/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.directmedia.onlinestore.officecore.entity;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author adonay
 */
public class ShoppingCart {
    private static Set<Work> items = new HashSet<>();

    public static Set<Work> getItems() {
        return items;
    }

    public static void setItems(Set<Work> items) {
        ShoppingCart.items = items;
    }
    
}
