package de.projektweihnachten.laby.addon2026.activities;


import de.projektweihnachten.laby.addon2026.packets.RegionPacket.RegionPacketPermsObject;
import java.util.ArrayList;
import java.util.List;

public class RegionPermission {

  private static boolean editable = false;
  private static boolean gamemode = false;
  private static boolean pwserver = false;

  private final String commandID;
  private final String name;
  private final boolean value;
  private final boolean allowed;


  private static String gamemodeName = null;
  private static String gamemodeInfo = null;
  private static String gamemodeUrl = null;


  private static String regionName = null;
  private static String regionOwner = null;
  private static ArrayList<RegionPermission> perms = new ArrayList<RegionPermission>();

  public RegionPermission(String commandID, String name, boolean value, boolean allowed) {
    this.commandID = commandID;
    this.name = name;
    this.value = value;
    this.allowed = allowed;

  }

  public static boolean isEditable() {
    return editable;
  }

  public static void setEditable(boolean editable) {
    RegionPermission.editable = editable;
  }

  public static void setGamemode(boolean gamemode) {
    RegionPermission.gamemode = gamemode;
  }

  public static boolean isGamemode() {
    return gamemode;
  }

  public static boolean isPwserver() {
    return pwserver;
  }

  public static void setPwserver(boolean pwserver) {
    RegionPermission.pwserver = pwserver;
  }

  public static String getGamemodeName() {
    return gamemodeName;
  }

  public static void setGamemodeName(String gamemodeName) {
    RegionPermission.gamemodeName = gamemodeName;
  }

  public static String getGamemodeInfo() {
    return gamemodeInfo;
  }

  public static void setGamemodeInfo(String gamemodeInfo) {
    RegionPermission.gamemodeInfo = gamemodeInfo;
  }

  public static String getGamemodeUrl() {
    return gamemodeUrl;
  }

  public static void setGamemodeUrl(String gamemodeUrl) {
    RegionPermission.gamemodeUrl = gamemodeUrl;
  }

  public static ArrayList<RegionPermission> getPerms() {
    return perms;
  }

  public static String getRegionName() {
    return regionName;
  }

  public static String getRegionOwner() {
    return regionOwner;
  }

  public String getCommandID() {
    return commandID;
  }

  public String getName() {
    return name;
  }

  public static void setRegion(String regionName, String regionOwner, List<RegionPacketPermsObject> permissions, boolean editable) {
    RegionPermission.regionName = regionName;
    RegionPermission.regionOwner = regionOwner;
    RegionPermission.editable = editable;

    ArrayList<RegionPermission> perms = new ArrayList<>();

    for (RegionPacketPermsObject p : permissions) {
      perms.add(new RegionPermission(p.cmd(), p.name(), p.value(), p.allowed()));
    }

    RegionPermission.perms = perms;
  }

  public boolean getValue() {
    return value;
  }

  public boolean isAllowed() {
    return allowed;
  }
}
