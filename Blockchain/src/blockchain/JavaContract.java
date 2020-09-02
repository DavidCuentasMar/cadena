/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import java.util.ArrayList;

/**
 *
 * @author laptop
 */
public abstract class JavaContract {
    //Quien lo triggerio
    public abstract boolean ejecutar(Transaction transaction);
}
