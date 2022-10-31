package io.knoldus.repository;

import com.fasterxml.jackson.databind.JsonNode;
import com.marklogic.client.document.JSONDocumentManager;
import com.marklogic.client.io.DocumentMetadataHandle;
import com.marklogic.client.io.JacksonHandle;
import com.marklogic.client.io.StringHandle;
import io.knoldus.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;

/**
 * The type Course repository.
 */
@Repository
public class CourseRepository {

    /**
     * The constant jsonDocumentManager.
     */
    @Autowired
    protected static JSONDocumentManager jsonDocumentManager;

    /**
     * Add.
     *
     * @param course the course
     */
    public void add(Course course) {
        DocumentMetadataHandle metadataHandle = new DocumentMetadataHandle();
        metadataHandle.getCollections().add("/course.json");

        JacksonHandle jacksonHandle = new JacksonHandle();
        JsonNode jsonNode = jacksonHandle.getMapper().convertValue(course, JsonNode.class);
        jacksonHandle.set(jsonNode);

        StringHandle stringHandle = new StringHandle(jsonNode.toString());
        jsonDocumentManager.write(getCourseId(course.getCourseId()), metadataHandle, stringHandle);
    }

    /**
     * Delete.
     *
     * @param courseId the course id
     */
    public void delete(Long courseId) {
        jsonDocumentManager.delete(getProductId(courseId));
    }

    /**
     * Find by course id course.
     *
     * @param courseId the course id
     * @return the course
     */
    public static Course findByCourseId(Long courseId) {
        JacksonHandle jacksonHandle = new JacksonHandle();
        jsonDocumentManager.read(getCourseId(courseId), jacksonHandle);
        return fetchCourse(jacksonHandle);
    }

    private static String getCourseId(Long courseId) {
        return null;
    }

    private static Course fetchCourse(JacksonHandle jacksonHandle) {
        try {
            JsonNode jsonNode = jacksonHandle.get();
            return jacksonHandle.getMapper().readValue(jsonNode.toString(), Course.class);
        } catch (IOException ioException) {
            throw new RuntimeException("Unable to cast to Course", ioException);
        }
    }

    private String getProductId(Long courseId) {
        return String.format("/couses/%d.json", courseId);
    }
}
