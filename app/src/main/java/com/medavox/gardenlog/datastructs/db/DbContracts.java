package com.medavox.gardenlog.datastructs.db;

import android.provider.BaseColumns;
import android.support.annotation.NonNull;

/**@author Adam Howard on 14/12/2016. */

public class DbContracts {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private DbContracts() {}

    /**Database Tables:
     * Action List
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
     * height (leggy? stumpy?)
     * */

    public static DBTable[] tables = new DBTable[] {
        new DBTable("Actions_Taken",
                "gardener TEXT",//foreign key to a gardener
                "actiontaken TEXT",//maybe an enum?
                "datetime LONG",
                "pertaining_to "),//foreign key to the affected plant/container

            new DBTable("Weather",
                    "weather INTEGER NOT NULL",
                    "timestamp TEXT",
                    "intensity INTEGER"),

            new DBTable("Gardens",
                    "garden name",
                    "location",
                    "members",//list of gardeners???
                    "area_plan BLOB"),//either a picture or some kind of vector format for floorplans

            new DBTable("Gardeners",
                    "name TEXT",
                    "email TEXT",//maybe??
                    "picture BLOB" ),

            new DBTable("Plants",
                    "scientific_name TEXT",
                    "variety TEXT",
                    "contained_in " ),//foreign key to the relevant container
            //plant's history can be derived from listings in the actions_taken table;
            //listing from there which have the same container or plant ID relate to it

            new DBTable("Containers",//plants know which container they're in;
                    // containers don't know which plants consider themselves inside them. SQL!
                    "in_garden TEXT",//foreign key to the garden it's in
                    "container_type "//basically an enum: foreign key to entry in table CONTAINER_TYPES
                    ),
            new DBTable("CONTAINER_TYPES",
                    "name NOT NULL UNIQUE"),
            new DBTable("Gardeners")

    };

    /** Each inner class defines a table name and its columns*/
    public static class DBTable implements TableDef {
        private String tableName;
        private String[] columnDefs;

        private DBTable() { throw new IllegalStateException("nope!");}

        public DBTable(@NonNull String tableName, String... inputPairs) {
            this.tableName = tableName;
            this.columnDefs = inputPairs;
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