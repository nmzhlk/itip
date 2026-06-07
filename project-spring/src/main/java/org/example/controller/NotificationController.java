package org.example.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.mapper.NotificationMapper;
import org.example.model.dto.NotificationDto;
import org.example.model.entity.Notification;
import org.example.model.enums.NotificationChannel;
import org.example.model.enums.NotificationStatus;
import org.example.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;
    private final NotificationMapper notificationMapper;

    private NotificationDto mapToDto(Notification notification) {
        return NotificationDto.builder().title(notification.getTitle()).message(notification.getMessage()).channel(notification.getChannel()).status(notification.getStatus()).createdAt(notification.getCreatedAt()).sentAt(notification.getSentAt()).recipientId(notification.getRecipient().getId()).build();
    }

    @PostMapping("/add")
    public NotificationDto createNotification(@RequestBody @Valid NotificationDto request) {
        Notification response = notificationService.createNotification(request);
        return mapToDto(response);
    }

    @GetMapping("/all")
    public List<NotificationDto> getAllNotifications() {
        return notificationMapper.toDtoList(notificationService.getAllNotifications());
    }

    @GetMapping("/{id}")
    public NotificationDto getNotificationById(@PathVariable Long id) {
        Notification response = notificationService.getNotificationById(id);
        return mapToDto(response);
    }

    @PutMapping("/{id}")
    public NotificationDto updateNotification(@PathVariable Long id, @RequestBody @Valid NotificationDto request) {
        Notification response = notificationService.updateNotification(id, request);
        return mapToDto(response);
    }

    @DeleteMapping("/{id}")
    public String deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
        return "Уведомление удалено";
    }

    @GetMapping("/status/{status}")
    public List<NotificationDto> getByStatus(@PathVariable NotificationStatus status) {
        return notificationService.getNotificationsByStatus(status).stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @GetMapping("/channel/{channel}")
    public List<NotificationDto> getByChannel(@PathVariable NotificationChannel channel) {
        return notificationService.getNotificationsByChannel(channel).stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @GetMapping("/recipient/{recipientId}")
    public List<NotificationDto> getByRecipientId(@PathVariable Long recipientId) {
        return notificationService.getNotificationsByRecipientId(recipientId).stream().map(this::mapToDto).collect(Collectors.toList());
    }

    // 6.1. GET /notifications/status-channel?status=CREATED&channel=EMAIL
    @GetMapping("/status-channel")
    public List<NotificationDto> getByStatusAndChannel(@RequestParam NotificationStatus status, @RequestParam NotificationChannel channel) {
        return notificationService.getNotificationsByStatusAndChannel(status, channel).stream().map(this::mapToDto).collect(Collectors.toList());
    }

    // 6.2. GET /notifications/status/{status}/sorted
    @GetMapping("/status/{status}/sorted")
    public List<NotificationDto> getByStatusSorted(@PathVariable NotificationStatus status) {
        return notificationService.getNotificationsByStatusSortedByDateAsc(status).stream().map(this::mapToDto).collect(Collectors.toList());
    }

    // GET /notifications/recipient/{recipientId}/sorted-desc
    @GetMapping("/recipient/{recipientId}/sorted-desc")
    public List<NotificationDto> getByRecipientSortedDesc(@PathVariable Long recipientId) {
        return notificationService.getNotificationsByRecipientSortedByDateDesc(recipientId).stream().map(this::mapToDto).collect(Collectors.toList());
    }

    // 6.3. GET /notifications/jpql?status=CREATED&channel=EMAIL
    @GetMapping("/jpql")
    public List<NotificationDto> getByStatusAndChannelJPQL(@RequestParam NotificationStatus status, @RequestParam NotificationChannel channel) {
        return notificationService.getNotificationsByStatusAndChannelCustom(status, channel).stream().map(this::mapToDto).collect(Collectors.toList());
    }

    // GET /notifications/native?status=CREATED&channel=EMAIL
    @GetMapping("/native")
    public List<NotificationDto> getByStatusAndChannelNative(@RequestParam String status, @RequestParam String channel) {
        return notificationService.getNotificationsNativeByStatusAndChannel(status, channel).stream().map(this::mapToDto).collect(Collectors.toList());
    }

    // GET /notifications/recipient/{recipientId}/status/{status}
    @GetMapping("/recipient/{recipientId}/status/{status}")
    public List<NotificationDto> getByRecipientIdAndStatus(@PathVariable Long recipientId, @PathVariable NotificationStatus status) {
        return notificationService.getNotificationsByRecipientIdAndStatus(recipientId, status).stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @PutMapping("/{id}/sent")
    public NotificationDto markAsSent(@PathVariable Long id) {
        Notification response = notificationService.updateNotificationStatusToSent(id);
        return mapToDto(response);
    }
}