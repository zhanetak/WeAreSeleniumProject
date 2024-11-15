package com.weare.utils;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestDataGenerator {
    private static final Random RANDOM = new Random();

    // Generate a unique username
    public static String generateUniqueUsername() {
        return "user" + generateRandomString(6);
    }

    // Generate a random comment
    public static String generateRandomComment() {
        return "Random comment " + generateRandomString(6);
    }

    // Generate a random title
    public static String generateRandomTitle() {
        String[] titles = {
                "Exciting News!",
                "Big Announcement",
                "Latest Updates",
                "Breaking News",
                "Special Offer",
                "New Features Released"
        };
        return titles[RANDOM.nextInt(titles.length)];
    }

    // Generate a random body for a post
    public static String generateRandomBody() {
        String[] bodies = {
                "We are excited to share this with you. Stay tuned for more details.",
                "This is a special announcement about something big. Keep an eye out for updates.",
                "Our team has been working hard on something new, and we're happy to share it with you.",
                "We've launched something awesome! Check it out and let us know what you think.",
                "A lot of great things are happening, and we want you to be part of it."
        };
        return bodies[RANDOM.nextInt(bodies.length)];
    }

    // Helper to generate a random alphanumeric string
    private static String generateRandomString(int length) {
        return RANDOM.ints(length, 0, 52) // Generate random integers between 0 and 51 (inclusive)
                .mapToObj(i -> (i < 26) ? Character.toString(i + 'a') : Character.toString(i - 26 + 'A'))
                .collect(Collectors.joining());
    }
}

