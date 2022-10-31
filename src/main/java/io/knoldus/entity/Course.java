package io.knoldus.entity;

/**
 * The type Course.
 */
public class Course {
    private long courseId;
    private String name;
    private String description;
    private Double price;

    /**
     * Instantiates a new Course.
     */
    public Course() {
    }

    /**
     * Instantiates a new Course.
     *
     * @param Id          the id
     * @param name        the name
     * @param description the description
     * @param price       the price
     */
    public Course(Long Id, String name, String description, Double price) {
        this.courseId = courseId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    /**
     * Gets course id.
     *
     * @return the course id
     */
    public long getCourseId() {
        return courseId;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public Double getPrice() {
        return price;
    }
}
