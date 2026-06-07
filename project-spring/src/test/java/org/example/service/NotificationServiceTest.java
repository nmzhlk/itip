package org.example.service;

import org.example.model.dto.NotificationDto;
import org.example.model.entity.Notification;
import org.example.model.entity.User;
import org.example.model.enums.NotificationChannel;
import org.example.repository.NotificationRepository;
import org.example.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NotificationServiceTest {

    @Mock
    private NotificationRepository notificationRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private NotificationService notificationService;

    @Test
    void shouldCreateNotification() {
        User user = new User();
        user.setId(1L);
        user.setEmail("ivan@example.com");

        NotificationDto dto = NotificationDto.builder()
                .title("Напоминание")
                .message("Завтра лекция по Spring")
                .channel(NotificationChannel.valueOf("EMAIL"))
                .recipientId(1L)
                .build();

        Notification savedNotification = new Notification();
        savedNotification.setTitle(dto.getTitle());
        savedNotification.setMessage(dto.getMessage());
        savedNotification.setChannel(dto.getChannel());
        savedNotification.setRecipient(user);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(notificationRepository.save(any(Notification.class))).thenReturn(savedNotification);

        Notification result = notificationService.createNotification(dto);

        assertNotNull(result);
        assertEquals("Напоминание", result.getTitle());
        assertEquals(NotificationChannel.valueOf("EMAIL"), result.getChannel());
        assertEquals(user, result.getRecipient());
    }

    @Test
    void shouldGetNotificationById() {
        Long id = 1L;
        Notification expected = new Notification();
        expected.setId(id);
        expected.setTitle("Тестовое уведомление");

        when(notificationRepository.findById(id)).thenReturn(Optional.of(expected));

        Notification result = notificationService.getNotificationById(id);

        assertNotNull(result);
        assertEquals(id, result.getId());
    }

    @Test
    void shouldThrowWhenNotificationNotFound() {
        Long id = 999L;
        when(notificationRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class,
                () -> notificationService.getNotificationById(id));
    }
}