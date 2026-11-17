# RSO Tracker

**RSO Tracker** is an Android application designed to help college students discover Registered Student Organizations (RSOs), find campus events, coordinate meetings, and increase student involvement.

This application is being developed as a final project for a Mobile Programming course at the University of Arkansas.

## Project Overview

College campuses have many student organizations, but finding events and coordinating meetings across different organizations can be difficult. RSO Tracker aims to bring these activities into one centralized application.

The goal is to make it easier for students to get involved on campus while providing organization leaders with tools to plan events, manage attendance, and coordinate schedules.

## Current Features

### 1. Event Dashboard
- Browse upcoming RSO events.
- View event names, dates, times, locations, and hosting organizations.
- Search for events by name, organization, location, or category.
- Filter events by category:
  - Professional
  - Multicultural
  - Social
  - Academic
  - Art

### 2. Event Details
- Select an event to view additional information.
- View the hosting organization, date, time, location, and category.
- Navigate between the event details and Home Screen.

### 3. Event Management
- Create new events through an in-app form.
- Enter event details and assign categories.
- Display newly created events on the Home Screen.
- Save event information locally so it remains available after restarting the application.

### 4. Saved Events
- Bookmark events for future reference.
- View bookmarked events in a separate section.
- Remove events from the saved list.
- Save bookmarks locally between app sessions.

### 5. Meeting Scheduler
- View a Monday–Friday availability grid.
- Select available meeting times.
- Save individual availability.
- Restore saved availability after reopening the application.

## Planned Features

The following features are planned for future development:

- **Group Meeting Scheduling:** A When2Meet-style tool that compares multiple members' availability and identifies the best meeting times.
- **Event Calendar:** A centralized calendar for student organizations.
- **QR Code Attendance:** Allow members to check in to events using QR codes.
- **Attendance Rewards:** Encourage student participation through points, giveaways, and other incentives.
- **Event Notifications:** Remind users about upcoming campus events.
- **Shared Data:** Allow events and meeting information to synchronize across multiple devices.
- **User Roles:** Provide different capabilities for students and RSO leaders.

## Technologies Used

- **Kotlin** — Application programming language
- **Android Studio** — Development environment
- **Jetpack Compose** — User interface development
- **Material Design 3** — UI components and styling
- **Android Internal Storage** — Local event and bookmark persistence
- **SharedPreferences** — Meeting availability storage
- **GitHub** — Version control and collaboration

## Project Structure

```text
RSOTracker/
└── app/
    └── src/
        └── main/
            └── java/
                └── com/example/rsotracker/
                    ├── MainActivity.kt
                    ├── HomeScreen.kt
                    ├── EventDetailsScreen.kt
                    ├── CreateEventScreen.kt
                    ├── EventStorage.kt
                    ├── MeetingSchedulerScreen.kt
                    └── ui/theme/
```

## Running the Application

1. Clone the repository.
2. Open the project in Android Studio.
3. Allow Gradle to synchronize.
4. Select an Android emulator or connected Android device.
5. Click **Run** to launch the application.

## Development Status

**In Development — Mobile Programming Final Project**

The current application includes a functional event dashboard, event creation, event bookmarking, local data persistence, and an individual meeting availability scheduler.

Additional features are being developed to support group scheduling, event attendance, and student engagement.

## Project Repository

[RSO Tracker on GitHub](https://github.com/https-haley/RSO-Tracker)

## Contributors

Developed collaboratively by University of Arkansas students as part of a Mobile Programming final project.
