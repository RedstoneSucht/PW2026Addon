package de.projektweihnachten.laby.addon2026.packets;

import net.labymod.serverapi.api.packet.Packet;
import net.labymod.serverapi.api.payload.io.PayloadReader;
import net.labymod.serverapi.api.payload.io.PayloadWriter;
import org.jetbrains.annotations.NotNull;

public class ServerPacket implements Packet {
  private int global;
  private int world;
  private int team;

  public ServerPacket(final int global, final int world, final int team) {
    this.global = global;
    this.world = world;
    this.team = team;
  }

  public int getGlobal() {
    return global;
  }

  public int getTeam() {
    return team;
  }

  public int getWorld() {
    return world;
  }

  @Override
  public void read(@NotNull PayloadReader reader) {
    this.global = reader.readInt();
    this.world = reader.readInt();
    this.team = reader.readInt();
  }

  @Override
  public void write(@NotNull PayloadWriter writer) {
    writer.writeInt(this.global);
    writer.writeInt(this.world);
    writer.writeInt(this.team);
  }

  @Override
  public String toString() {
    return "ServerPacket{" +
        "global=" + global +
        ", world=" + world +
        ", team=" + team +
        '}';
  }
}
