package entities.main;

public record Position(float x, float y) {

    public Position plus(Position other){
        return new Position(x + other.x, y + other.y);
    }

    public Position minus(Position other){
        return new Position(x - other.x, y - other.y);
    }

    public Position times(float k){
        return new Position(x * k, y * k);
    }

    public float length(){
        return (float) Math.sqrt(x*x + y*y);
    }

    public float distanceTo(Position other){
        return this.minus(other).length();
    }

    public Position normalized(){
        float len = length();
        if(len == 0) return this;

        return new Position(x / len, y / len);
    }

    public float dot(Position other){
        return x * other.x + y*other.y;
    }
}

