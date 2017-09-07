import java.util.Random;
public class mapGen{
    int[][] spawnRoom=getSpawnRoom;
    int[][] exitRoom=getExitRoom;
    
    public static void main(String[] args){
        int mapX=0;
        int mapY=0;
        Random rn=new Random();
        mapX=rn.nextInt(3)+7;
        mapY=rn.nextInt(3)+7;
        int[][] mapGrid=new int[mapX][mapY];

    }
    public class getSpawnRoom{
        
    }
    public class getExitRoom{

    }
    public class fillRooms{

    }
}