package de.projektweihnachten.laby.addon2026.packets;

import net.labymod.serverapi.api.packet.Packet;
import net.labymod.serverapi.api.payload.io.PayloadReader;
import net.labymod.serverapi.api.payload.io.PayloadWriter;
import org.jetbrains.annotations.NotNull;

public class GameinfoPacket implements Packet {
  private boolean gamemode;
  private String gamemodeUrl;
  private String gamemodeName;
  private String gamemodeInfo;

  public GameinfoPacket(final boolean gamemode, final String gamemodeUrl, final String gamemodeName, final String gamemodeInfo) {
    this.gamemode = gamemode;
    this.gamemodeUrl = gamemodeUrl;
    this.gamemodeName = gamemodeName;
    this.gamemodeInfo = gamemodeInfo;
  }

  public boolean isGamemode() {
    return gamemode;
  }

  public String getGamemodeInfo() {
    return gamemodeInfo;
  }

  public String getGamemodeName() {
    return gamemodeName;
  }

  public String getGamemodeUrl() {
    return gamemodeUrl;
  }

  @Override
  public void read(@NotNull PayloadReader reader) {
    this.gamemode = reader.readBoolean();
    this.gamemodeUrl = reader.readOptionalString();
    this.gamemodeName = reader.readOptionalString();
    this.gamemodeInfo = reader.readOptionalString();
  }

  @Override
  public void write(@NotNull PayloadWriter writer) {
    writer.writeBoolean(this.gamemode);
    writer.writeOptionalString(this.gamemodeUrl);
    writer.writeOptionalString(this.gamemodeName);
    writer.writeOptionalString(this.gamemodeInfo);
  }

  @Override
  public String toString() {
    return "GameinfoPacket{" +
            "gamemode=" + gamemode +
            ", gamemodeUrl='" + gamemodeUrl + '\'' +
            ", gamemodeName='" + gamemodeName + '\'' +
            ", gamemodeInfo='" + gamemodeInfo + '\'' +
            '}';
  }
}
