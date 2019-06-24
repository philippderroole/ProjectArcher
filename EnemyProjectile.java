import processing.core.*;

public class EnemyProjectile extends Projectile{

    
    public EnemyProjectile(PVector startPosition, PVector direction, float damage, View view){
        size = 10;
    }
    
    public float intersectsPlayer(PVector position, float size){
        PVector pToB = this.position.sub(position);
        float pToBLength = (float) Math.sqrt(Math.pow(pToB.x, 2) + Math.pow(pToB.y, 2));
        float minLength = this.size + size / 2;
        if(pToBLength < minLength){
            return damage;
        } else {
            return 0;
        }
    }
}