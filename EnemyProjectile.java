import processing.core.*;

public class EnemyProjectile extends Projectile{
    private float size;
    
    public EnemyProjectile(){
        size = 10;
    }
    
    public float intersectsPlayer(PVector position, float size){
        PVector pToB = this.position.sub(position);
        float pToBLength = (float) Math.sqrt(Math.pow(pToB.x, 2) + Math.pow(pToB.y, 2));
        float minLength = this.size + size / 2;
        if(pToBLength < minLength){
            System.out.println("Treffer!");
            return damage;
        } else {
            return 0;
        }
    }
}