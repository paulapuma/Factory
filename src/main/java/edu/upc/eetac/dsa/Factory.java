package edu.upc.eetac.dsa;

import org.apache.log4j.Logger;

import java.util.HashMap;

import static java.lang.Class.*;

public class Factory {
    final static Logger log = Logger.getLogger(Factory.class.getName());

    private static final String PACKAGE = "edu.upc.eetac.dsa";
    private static Factory instance;
    private HashMap<String, Command> cache;

    private Factory() {
        this.cache = new HashMap<String, Command>();
    }

    public static Factory getInstance() {
        if (instance==null) instance = new Factory();

        return instance;
    }

    private Command getCommand2(String idCommand) {

        Command command = null;
        Class theClass = null;
        try {
            theClass = Class.forName(PACKAGE+"."+idCommand);
            command = (Command)theClass.newInstance();
        } catch (InstantiationException e) {
            //Error message because the class that we're trying to load isn't instantiated
            log.error(e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            //Error message because we don't have permission in the class that we're trying to load
            log.error(e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            //Error message because the class that we're trying to load doesn't exist
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return command;
    }

    public Command getCommand(String idCommand) {
        Command c = cache.get(idCommand);
        if (c==null) {
            log.info("We use the class loader");
            c = getCommand2(idCommand);
            cache.put(idCommand, c);
        }
        else {
            log.info("CACHE");
        }
        return c;
    }
}
