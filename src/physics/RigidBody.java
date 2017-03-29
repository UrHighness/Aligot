package physics;

/**
 * Created by ben on 18/03/17.
 */
public class RigidBody {

    Vector2D position;       // in meter
    Vector2D velocity;       // in meter/second
    Vector2D acceleration;   // in meter/second²
    Vector2D appliedForce;
    double size;             // radius in meter
    double mass;             // in kg
    double restitution;      // no unit, between 0 and 1 where 1 is perfect restitution
    boolean attractive;      // is this body attracting the others?
    boolean staticObject;    // is this body moving?

    public RigidBody(Vector2D position, double size, double masse){
        this.position = position;
        this.size = size;
        this.mass = masse;
        velocity = new Vector2D(0, 0);
        acceleration = new Vector2D(0 , 0);
        appliedForce = new Vector2D(0,0);
        restitution = 0.5;
        attractive = false;
        staticObject = false;
    }

    public void updatePosition(double dt){
        position =  position.add(velocity.multiply(dt));
    }

    public void updateVelocity(double dt){
        velocity = velocity.add(acceleration.multiply(dt));
    }

    public void setAttractive(boolean attractive){
        this.attractive = attractive;
    }

    public boolean getAttractive(){
        return this.attractive;
    }

    public void setStaticObject( boolean staticObject ){
        this.staticObject = staticObject;
    }

    public boolean getStaticObject(){
        return this.staticObject;
    }

    public Vector2D getVelocity() {
        return velocity;
    }

    public Vector2D getPosition() {
        return position;
    }

    public void setVelocity(Vector2D velocity) {
        this.velocity = velocity;
    }

    public void updateAcceleration(){
        acceleration = this.appliedForce.Divide(mass);
    }

    public Vector2D getAppliedForce() {
        return appliedForce;
    }

    public void resetAppliedForces(){
        this.appliedForce = Vector2D.getNull();
    }

    public void applyForce(Vector2D force) {
        this.appliedForce = this.appliedForce.add(force);
    }

    public void update(Vector2D sommeForce, double dt){
        this.updateAcceleration();
        this.updateVelocity(dt);
        this.updatePosition(dt);
    }

    public String toString(){
        return String.format("Rigidbody %d\nPosition: %s\nVelocity: %s", hashCode(), this.position.toString(), this.velocity.toString());
    }

}
