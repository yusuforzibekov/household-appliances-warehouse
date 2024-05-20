package edu.itpu.fopjava_course_work.service;

import edu.itpu.fopjava_course_work.entity.Feedback;

import javax.mail.MessagingException;
import java.io.IOException;

public interface FeedbackService {
    void sendFeedback(Feedback feedback) throws MessagingException, IOException;
}