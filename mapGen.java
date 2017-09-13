import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class mapGen{

    public static int mapX=0;
    public static int mapY=0;
    static String[][] mapGrid;
    public static void main(String[] args){
        mapX=getRandomNumber(3,10);
        mapY=getRandomNumber(3,10);
        mapGrid=new String[mapX][mapY];
        fillRooms();
        System.out.println("");
    }
    public static void getSpawnRoom(){
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
    public static void getExitRoom(){
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
        if(mapGrid[x][y]==null){   //this line gives an error fucking reeeee
            return true;
        }
        else{
            return false;
        } 
    }
    public static void fillRooms(){
        getSpawnRoom();
        getExitRoom();
        getShop();
        for(int x=0;x<mapX;x++){
            for(int y=0;y<mapY;y++){
                if(isRoomEmpty(x,y)){
                    int roomDecider=getRandomNumber(1,4);
                    switch(roomDecider){
                        case 1: mapGrid[x][y]="monster";
                        case 2: mapGrid[x][y]="loot";
                        case 3: mapGrid[x][y]="chest";
                        case 4: mapGrid[x][y]="standard";
                    }
                }
            }
        }
    }
}