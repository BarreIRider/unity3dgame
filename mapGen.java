import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.image.BufferedImage;
import java.io.File;


public class mapGen{

    public static int mapX=0;
    public static int mapY=0;
    static String[][] mapGrid;
    static String[][] tileGrid;
    static int currentTileX;
    static int currentTileY;
    static int currentSlotX;
    static int currentSlotY;
    public static void main(String[] args){
        mapX=5;   //removed random map size, is now set to 5
        mapY=5;   //removed random map size, is now set to 5
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
        tileGrid=new String[(mapX*10)+mapX+1][(mapY*10)+mapY+1]; 
        currentTileX=0;
        currentTileY=0;
        while(currentSlotX<=mapX){
            while(currentSlotY<=mapY){
                String currentSlot=mapGrid[currentSlotX][currentSlotY];
                if(currentTileX==0||currentTileX==11||currentTileX==22||currentTileX==33||currentTileX==44||currentTileX==55||currentTileY==0||currentTileY==11||currentTileY==22||currentTileY==33||currentTileY==44||currentTileY==55){ //5 x wall tiles, 5 y wall tiles
                    tileGrid[currentTileX][currentTileY]="4";
                }
                else{
                    switch(currentSlot){
                        case "monster":
                            getMonsterRoom();
                            break;
                        case "loot":
                            getTreasureRoom();
                            break;
                        case "chest":
                            getChestRoom();
                            break;
                        case "standard":
                            getStandardRoom();
                            break;
                        case "shop":
                            getShopRoom();
                            break;
                        case "spawn":
                            getSpawnRoom();
                            break;
                        case "exit":
                            getExitRoom();
                            break;
                        default:
                            //ERROR
                            break;
                    }
                }
                currentSlotY++;
            }
            currentSlotX++;
        }
    }
    public static void getMonsterRoom(){
        //this should go through 10 loops giving random IDs to each tile.
        for(int x=0;x<=10;x++){
            for(int y=0;y<=10;y++){
                int currentTileId=getRandomNumber(0,7);
                switch (currentTileId) {
                    case 0: //empty
                        tileGrid[currentTileX][currentTileY]="0";
                        break;
                    case 1: //empty
                        tileGrid[currentTileX][currentTileY]="0";
                        break;
                    case 2: //empty
                        tileGrid[currentTileX][currentTileY]="0";
                        break;
                    case 3: //empty
                        tileGrid[currentTileX][currentTileY]="0";
                        break;
                    case 4: //monster
                        tileGrid[currentTileX][currentTileY]="1";
                        break;
                    case 5: //monster
                        tileGrid[currentTileX][currentTileY]="1";
                        break;
                    case 6: //monster
                        tileGrid[currentTileX][currentTileY]="1";
                        break;
                    case 7: //chest
                        tileGrid[currentTileX][currentTileY]="3";
                        break;
                    default:
                        tileGrid[currentTileX][currentTileY]="0";
                        break;
                }
            }
        }

    }
    public static void getTreasureRoom(){
        //this should go through 10 loops giving random IDs to each tile.
        for(int x=0;x<=10;x++){
            for(int y=0;y<=10;y++){
                int currentTileId=getRandomNumber(0,7);
                switch (currentTileId) {
                    case 0: //empty
                        tileGrid[currentTileX][currentTileY]="0";
                        break;
                    case 1: //empty
                        tileGrid[currentTileX][currentTileY]="0";
                        break;
                    case 2: //empty
                        tileGrid[currentTileX][currentTileY]="0";
                        break;
                    case 3: //empty
                        tileGrid[currentTileX][currentTileY]="0";
                        break;
                    case 4: //monster
                        tileGrid[currentTileX][currentTileY]="1";
                        break;
                    case 5: //item
                        tileGrid[currentTileX][currentTileY]="2";
                        break;
                    case 6: //chest
                        tileGrid[currentTileX][currentTileY]="3";
                        break;
                    case 7: //chest
                        tileGrid[currentTileX][currentTileY]="3";
                        break;
                    default:
                        tileGrid[currentTileX][currentTileY]="0";
                        break;
                }
            }
        }

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