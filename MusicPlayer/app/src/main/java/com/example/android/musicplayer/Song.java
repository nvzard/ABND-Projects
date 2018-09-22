package com.example.android.musicplayer;

import android.support.annotation.NonNull;

public class Song implements Comparable<Song> {

    private String songName;
    private String albumName;
    private String artistName;
    private String songLength;
    private int albumArtId = R.drawable.album_art_default;

    public Song(String songName, String albumName, String artistName, String songLength) {
        this.songName = songName;
        this.albumName = albumName;
        this.artistName = artistName;
        this.songLength = songLength;
    }

    public Song(String songName, String albumName, String artistName, String songLength, int albumArtId) {
        this(songName, albumName, artistName, songLength);
        this.albumArtId = albumArtId;
    }

    public String getSongName() {
        return songName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getSongLength() {
        return songLength;
    }

    public int getAlbumArtId() {
        return albumArtId;
    }

    @Override
    public int compareTo(@NonNull Song o) {
        return this.songName.compareTo(o.songName);
    }
}
