/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Condition;

/**
 *
 * @author Zento
 */
public abstract class Condition<E> {
    
    public abstract boolean evaluate(E target);
}
