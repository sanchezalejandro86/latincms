package com.latinnet.latincms.model.dto;

import java.util.ArrayList;
import java.util.List;


public class NodeDTO{

    private String name;
    private List<NodeDTO> nodes = new ArrayList<NodeDTO>();
    private boolean open;
    private int level;
    
    public NodeDTO(String name, int level){
	this.name = name;
	this.level = level;
	this.open = false;
    }

    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public List<NodeDTO> getNodes(){
        return nodes;
    }
    
    public void setNodes(List<NodeDTO> nodes){
        this.nodes = nodes;
    }

    public boolean isOpen(){
        return open;
    }

    public void setOpen(boolean open){
        this.open = open;
    }

    public int getLevel(){
        return level;
    }

    public void setLevel(int level){
        this.level = level;
    }
}
