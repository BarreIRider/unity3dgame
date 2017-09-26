import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class mapGen{

    public static int mapX=0;
    public static int mapY=0;
    static String[][] mapGrid;
    static String[][] tileGrid;
    int currentTileX;
    int currentTileY;
    int currentSlotX;
    int currentSlotY;
    public static void main(String[] args){
        mapX=getRandomNumber(3,5);
        mapY=getRandomNumber(3,5);
        mapGrid=new String[mapX][mapY];
        fillRooms();
        System.out.println("");
    }
    public static void getSpawn(){
        boolean loop=true;
        int spawnX=0;
        int spawnY=0;
        while(loop==true){
            spawnX=getRandomNumber(1,mapX);
            spawnY=getRandomNumber(1,mapY);
            if(isRoomEmpty(spawnX, spawnY)){
                loop=false;
            }
            else{
                loop=true;
            }
        }
        mapGrid[spawnX][spawnY]="spawn";    
    }
    public static void getExit(){
        boolean loop=true;
        int exitX=0;
        int exitY=0;
        while(loop==true){
            exitX=getRandomNumber(1,mapX);
            exitY=getRandomNumber(1,mapY);
            if(isRoomEmpty(exitX, exitY)){
                loop=false;
            }
            else{
                loop=true;
            }
        }
        mapGrid[exitX][exitY]="exit";
    }
    public static void getShop(){
        boolean loop=true;
        int shopX=0;
        int shopY=0;
        while(loop==true){
            shopX=getRandomNumber(1,mapX);
            shopY=getRandomNumber(1,mapY);
            if(isRoomEmpty(shopX, shopY)){
                loop=false;
            }
            else{
                loop=true;
            }
        }
        mapGrid[shopX][shopY]="shop";
    }
    public static int getRandomNumber(int min,int max){
        int randomNum = ThreadLocalRandom.current().nextInt(min, max);
        
        return randomNum;
    }
    public static boolean isRoomEmpty(int x, int y){
        if(mapGrid[x][y]==null){
            return true;
        }
        else{
            return false;
        } 
    }
    public static void fillRooms(){
        getSpawn();
        getExit();
        getShop();
        for(int x=0;x<mapX;x++){
            for(int y=0;y<mapY;y++){
                if(isRoomEmpty(x,y)){
                    int roomDecider=getRandomNumber(1,4);
                    switch(roomDecider){
                        case 1: mapGrid[x][y]="monster";
                        break;
                        case 2: mapGrid[x][y]="loot";
                        break;
                        case 3: mapGrid[x][y]="chest";
                        break;
                        case 4: mapGrid[x][y]="standard";
                        break;
                    }
                }
            }
        }
    }
    public static void initialiseMap(){
        currentSlotX=0;
        currentSlotY=0;
        if() //walls should be on tile 1, 12, 23, 34 etc

        // tileGrid[][]=new String[(mapX*10)+mapX][(mapY*10)+mapY];
        // currentSlotX=0;
        // currentSlotY=0;     
        // currentTileX=0;
        // currentTileY=0;
        // tileGrid[currentTileX][currentTileY]="wall";
        // while(currentSlotX<mapX){
        //     while(currentSlotY<mapY){
        //         String currentSlot=mapGrid[currentSlotX][currentSlotY];
        //         switch(currentSlot){
        //             case "monster":getMonsterRoom();
        //             break;
        //             case "loot":getTreasureRoom();
        //             break;
        //             case "chest":getChestRoom();
        //             break;
        //             case "standard":getStandardRoom();
        //             break;
        //             case "shop":getShopRoom();
        //             break;
        //             case "spawn":getSpawnRoom()
        //             break;
        //             case "exit":getExitRoom();
        //             break;
        //         }
        //         currentSlotY++;
        //     }
        //     currentSlotX++;
        // }
    }
    public static void getMonsterRoom(){
        
    }
    public static void getTreasureRoom(){

    }
    public static void getChestRoom(){  
        
    }
    public static void getStandardRoom(){ 
        
    }
    public static void getShopRoom(){
        
    }
    public static void getSpawnRoom(){
        
    }
    public static void getExitRoom(){
        
    }
    public static void writeToImage(){

    }
}