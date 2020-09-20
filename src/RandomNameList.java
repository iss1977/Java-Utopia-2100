// you can use this Class to generate a random name.

public class RandomNameList {
    static public String[] randomNameList = null;

    public String[] getRandomNameListAsArray() {
        return randomNameList;
    }
    public static String getRandomName(){
        initNameList();
        return randomNameList[GlobalStacker.generateRandomInteger(0,randomNameList.length-1)];

    }
    private static void initNameList(){ //here we create randomNameList static variable. if it exists, we skip.
        if (randomNameList == null)
        randomNameList = FileReader.readFileContentToArray("random_names_list.txt",',');
    }

    private RandomNameList(){

    }

} // end of class RandomNameList
