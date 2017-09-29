package core;

/**
 * Интерфейс для игровых объектов, реагирующих на геометрическое пересечение с другими игровыми объектами.
 */
public interface Intersectable {
    public void onIntersect(Intersectable intersectedWith);
}
