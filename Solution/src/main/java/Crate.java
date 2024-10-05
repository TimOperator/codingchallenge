/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Tim
 */
public class Crate implements Iterator {

    private int[] values;
    private int position = 0;
    
    /**
     * Constructor to initialize the iterator with an array of integers
     * 
     * @param values 
     */
    public Crate(int[] values) {
        this.values = values;
    }
    
    /**
     * Returns true, if the iterator has more elements.
     * 
     * @return true if there are more elements to iterate over
     */
    @Override
    public boolean hasNext() {
        return (position < values.length);
    }

    /**
     * Returns the next element in the iteration.
     * 
     * @return the next integer in the array
     * @throws NoSuchElementException if there are no more elements
     */
    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No next element.");
        }
        return values[position++];
    }
    
}