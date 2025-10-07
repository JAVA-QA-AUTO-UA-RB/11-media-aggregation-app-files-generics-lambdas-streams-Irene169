package com.example.media.util;

import com.example.media.classes.Playlist;
import com.example.media.classes.Track;
import com.example.media.classes.Video;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;


public class MediaStatisticsWriter {

    public static void writeTrackStats(Playlist<Track> playlist, String filename) throws IOException {
        List<Track> tracks = playlist.getItems();
        int count = tracks.size();
        double avgDuration = tracks.stream().mapToInt(Track::getDuration).average().orElse(0);

        List<Track> top3 = tracks.stream()
                .sorted(Comparator.comparingInt(Track::getRating).reversed().thenComparing(Comparator.comparingInt(Track::getDuration).reversed()))
                .limit(3)
                .collect(Collectors.toList());

        List<Track> popTracks = tracks.stream()
                .filter(track -> track.getGenre().equalsIgnoreCase("Pop"))
                .collect(Collectors.toList());

        try (PrintWriter writer = new PrintWriter(filename)) {
            writer.println("Tracks count: " + count);
            writer.println("Average duration: " + (int) avgDuration + " seconds\n");

            writer.println("Top 3 tracks by rating: ");
            for (int i = 0; i < top3.size(); i++) {
                Track t = top3.get(i);
                writer.println((i + 1) + ". " + t.getTitle() + " (rating " + t.getRating() + ")");
            }

            writer.println("\nPop tracks: ");
            popTracks.forEach(t -> writer.println("- " + t.getTitle()));
            writer.println("-------------------------------");
        }
    }

    public static void writeVideoStats(Playlist<Video> playlist, String filename) throws IOException {
        List<Video> videos = playlist.getItems();
        int count = videos.size();
        double avgDuration = videos.stream().mapToInt(Video::getDuration).average().orElse(0);

        List<Video> top3 = videos.stream()
                .sorted(Comparator.comparingInt(Video::getViews).reversed())
                .limit(3)
                .collect(Collectors.toList());

        List<Video> educationVideos = videos.stream()
                .filter(v -> v.getCategory().equalsIgnoreCase("Education"))
                .collect(Collectors.toList());

        try (PrintWriter writer = new PrintWriter(filename)) {
            writer.println("Videos count: " + count);
            writer.println("Average duration: " + (int) avgDuration + " seconds\n");

            writer.println("Top 3 videos by views: ");
            for (int i = 0; i < top3.size(); i++) {
                Video v = top3.get(i);
                writer.println((i + 1) + ". " + v.getTitle() + " (" + v.getViews() + " views)");
            }

            writer.println("\nEducation videos: ");
            educationVideos.forEach(v -> writer.println("- " + v.getTitle()));
            writer.println("-----------------------");
        }
    }
}