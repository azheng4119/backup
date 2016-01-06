package project.save;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveFile {
	
	private ItemState itemState;//saves collected and uncollected items
	private int overWorldX;//saves location of sprite in overworld
	private int overWorldY;
	private long creationTime;
	private int slotNumber;
	
	public static final String SAVE_FILE_DIRECTORY = System.getProperty("user.home")+File.separator+"saveFiles"+File.separator;
	
	public static final String SLOT_NUMBER_TAG = "slotNumber";
	public static final String NEW_TAG = "newFile";
	public static final String CREATION_TAG = "creationTime";
	public static final String X_TAG = "overWorldX";
	public static final String Y_TAG = "overWorldY";
	public static final String POTION_TAG = "potionCollected";
	
	public SaveFile(int slotNumber, ItemState itemState, int overworldX, int overWorldY, long creationTime) {
		this.slotNumber = slotNumber;
		this.itemState=itemState;
		this.overWorldX=overworldX;
		this.overWorldY=overWorldY;
		this.creationTime = creationTime;
	}

	//create a file from save text
	public SaveFile(String rawSaveText) {
		this.slotNumber = SaveUtility.getIntFromTag(rawSaveText, SLOT_NUMBER_TAG);
		if(SaveUtility.getBooleanFromTag(rawSaveText, SaveFile.NEW_TAG))creationTime=System.currentTimeMillis();
		else creationTime=SaveUtility.getLongFromTag(rawSaveText, CREATION_TAG);
		itemState = new ItemState(SaveUtility.getBooleanFromTag(rawSaveText, POTION_TAG));
		overWorldX=SaveUtility.getIntFromTag(rawSaveText, X_TAG);
		overWorldY=SaveUtility.getIntFromTag(rawSaveText, Y_TAG);
	}
	
	public SaveFile(int number){
		slotNumber=number;
		creationTime=System.currentTimeMillis();
		itemState = new ItemState(false);
		overWorldX=400;
		overWorldY=400;
	}

	public ItemState getItemState() {
		return itemState;
	}

	public void setItemState(ItemState itemState) {
		this.itemState = itemState;
	}

	public int getOverWorldX() {
		return overWorldX;
	}

	public void setOverWorldX(int overWorldX) {
		this.overWorldX = overWorldX;
	}

	public int getOverWorldY() {
		return overWorldY;
	}

	public void setOverWorldY(int overWorldY) {
		this.overWorldY = overWorldY;
	}

	public boolean save() {
		String fileName = SAVE_FILE_DIRECTORY+
				"save"+slotNumber+".txt";

/**
        <newFile>true</newFile>
        <creationTime>0</creationTime>
        <overWorldX>400</overWorldX>
        <overWorldY>400</overWorldY>
        <potionCollected>false</potionCollected>
        */
        
        try {
            // Assume default encoding.
            FileWriter fileWriter = new FileWriter(fileName);
            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =                new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
            bufferedWriter.write(dataWithTag(SLOT_NUMBER_TAG,""+slotNumber));
            bufferedWriter.write(dataWithTag(NEW_TAG,""+false));
            bufferedWriter.write(dataWithTag(CREATION_TAG,""+creationTime));
            bufferedWriter.write(dataWithTag(POTION_TAG,""+itemState.isPotionCollected()));
            bufferedWriter.write(dataWithTag(X_TAG,""+overWorldX));
            bufferedWriter.write(dataWithTag(Y_TAG,""+overWorldY));


            // Always close files.
            bufferedWriter.close();
            return true;
        }
        catch(IOException ex) {

            ex.printStackTrace();
            return false;
        }
	}

	private String dataWithTag(String tag, String string) {
		return "<"+tag+">"+string+"</"+tag+">";
	}

	public int getNumber() {
		return slotNumber;
	}
	
	

}
