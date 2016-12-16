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
        new DBTable("Action List",
                "gardener", "TEXT",
                "action taken", "TEXT",//maybe an enum?
                "datetime", "LONG"),

            new DBTable("Weather",
                    "weather", "INTEGER",
                    "timestsmp", "TEXT",
                    "intensity", "INTEGER")
    };

    /** Each inner class defines a table name and its columns*/
    public static class DBTable implements TableDef {
        private String tableName;
        private String[][] columnPairs;

        private DBTable() { throw new IllegalStateException("nope!");}

        public DBTable(@NonNull String tableName, String... inputPairs) {
            if(columnPairs.length < 2 || (columnPairs.length % 2 ) != 0 ) {
                throw new IllegalArgumentException("incorrect number of column pairs." +
                        "Number of column strings passed: "+columnPairs.length);
            }
            this.tableName = tableName;
            this.columnPairs = new String[inputPairs.length/2][];
            for(int i = 0; i < inputPairs.length; i += 2) {
                columnPairs[i/2] = new String[] {inputPairs[i], inputPairs[i+1]};
            }
        }

        @Override
        public String getTableName() {
            return tableName;
        }

        @Override
        public String[][] getColumnNameTypePairs() {
            return columnPairs;
        }
    }

    public interface TableDef extends BaseColumns {
        String getTableName();
        String[][] getColumnNameTypePairs();
    }

}