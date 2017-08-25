/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpacontroller;

import java.util.HashMap;
import javax.persistence.Persistence;

/**
 *
 * @author Dixie
 */
public class Structure {
            public static void main(String[] args) {
        HashMap proberties = new HashMap();
        proberties.put("javax.persistence.sql-load-script-source", "scripts/ClearDB.sql");
        Persistence.generateSchema("jpaPU", proberties);
        
        proberties.remove("javax.persistence.sql-load-script-source");
        Persistence.generateSchema("jpaPU", proberties);
    }
}
