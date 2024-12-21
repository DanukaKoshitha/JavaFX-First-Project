package db;

import Model.Item;

import java.util.ArrayList;
import java.util.List;

public class dbCollection {
    private static dbCollection instance;

    private List<Item> itemList;
    private dbCollection(){
        itemList = new ArrayList<>();
    }
    public List<Item> getConnection(){
        return itemList;
    }
    public static dbCollection getInstance(){
        return instance==null?instance=new dbCollection():instance;
    }
}
