package com.medavox.gardenlog.db;

import android.provider.BaseColumns;
import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

/**@author Adam Howard on 14/12/2016. */

public class DbContracts {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private DbContracts() {}

    /**Database Tables:
     * Actions Taken
     * Actions to do
     * Observations (possibly a subtype of Action List) - poor leaf growth, yellow leaves, productive crop etc
     * Weather a few times a day
     * list of plant varieties/beds being grown, and their states
     * list of gardeners (name)
     * database of general info about the plant/variety, preferred growing conditions etc -- possibly online?
     * */

    /**Freeform text fields are harder to parse data from,
     * but users get frustrated with endless menus and drop-down lists,
     * so how about an enum searchtext box seemingly-text field,
     * which suggests options for the enums based on stuff typed in?

     * record light levels from light sensor on device
     * get general weather from intenet (Met office?)
     *
     * * Observations:
     * leaves (yellowed? burnt-looking?)
     * height (leggy? stumpy?) */

            public static final String ACTIONS_TAKEN = "ACTIONS_TAKEN";
            public static final String ACTIONS_TO_DO = "ACTIONS_TO_DO";
            public static final String WEATHER = "WEATHER";
            public static final String GARDEN_PLOTS = "GARDEN_PLOTS";
            public static final String GARDENERS = "GARDENERS";
            public static final String PLANTS = "PLANTS";
            public static final String CONTAINERS = "CONTAINERS";
            public static final String ACTION_TYPES = "ACTION_TYPES";
            public static final String CONTAINER_TYPES = "CONTAINER_TYPES";
    //DBTable[] tables = new DBTable[] {
    //public static DBTable[] tables = new DBTable[] {
    public static Map<String, DBTable> tables = new HashMap<String, DBTable>();
    static {

        tables.put(ACTIONS_TAKEN, new DBTable(ACTIONS_TAKEN,
                "FOREIGN KEY(gardener) REFERENCES "+GARDENERS+"(id)",
                "FOREIGN KEY(action_taken) REFERENCES "+ACTION_TYPES+"(id)",//an enum
                "datetime LONG",
                "FOREIGN KEY(pertaining_to) REFERENCES "+CONTAINERS+"(id)"));//the affected plant/container


        tables.put(ACTIONS_TO_DO, new DBTable(ACTIONS_TO_DO,
                "FOREIGN KEY(action_to_take) REFERENCES "+ACTION_TYPES+"(id)",//an enum
                "earliest_time LONG",
                "latest_time LONG NOT NULL"));

        //TODO:this table's schema
        tables.put(PLANTS, new DBTable(PLANTS,
                "scientific_name TEXT NOT NULL",
                "common_name TEXT NOT NULL",
                "variety TEXT",
                "contained_in "));//foreign key to the relevant container
                //plant's history can be derived from listings in the actions_taken table;
                //listing from there which have the same container or plant ID relate to it

        //TODO:this table's schema
        tables.put(CONTAINERS, new DBTable(CONTAINERS,//plants know which container they're in;
                // containers don't know which plants consider themselves inside them. SQL!
                "name TEXT",//maybe optional
                "description TEXT",//definitely optional

                "FOREIGN KEY(in_garden) REFERENCES "+GARDEN_PLOTS+"(id)",//the garden it's in
                "container_type "));//basically an enum: foreign key to entry in table CONTAINER_TYPES


        //TODO:this table's schema
        //Immutable tables; used as enums
        tables.put(CONTAINER_TYPES, new DBTable(CONTAINER_TYPES,
                        "name NOT NULL UNIQUE"));

        //TODO:this table's schema
        tables.put(ACTION_TYPES, new DBTable(ACTION_TYPES,
                "name NOT NULL UNIQUE"
                ));
    }

    /**Defines a table name and its columns`*/
    public static class DBTable implements TableDef {
        private String tableName;
        private String[] columnDefs;

        private DBTable() { throw new IllegalStateException("nope!");}

        public DBTable(@Required String tableName, String... colDefs) {
            this.tableName = tableName;
            this.columnDefs = colDefs;
        }

        @Override
        public String getTableName() {
            return tableName;
        }

        @Override
        public String[] getColumDefinitions() {
            return columnDefs;
        }
    }

    public interface TableDef extends BaseColumns {
        String getTableName();
        String[] getColumDefinitions();
    }

}