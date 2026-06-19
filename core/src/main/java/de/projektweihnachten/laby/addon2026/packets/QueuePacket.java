package de.projektweihnachten.laby.addon2026.packets;

import net.labymod.serverapi.api.packet.Packet;
import net.labymod.serverapi.api.payload.io.PayloadReader;
import net.labymod.serverapi.api.payload.io.PayloadWriter;
import org.jetbrains.annotations.NotNull;

public class QueuePacket implements Packet {
  private int position;

  public QueuePacket(final int position) {
    this.position = position;
  }

  public int getPosition() {
    return position;
  }

  @Override
  public void read(@NotNull PayloadReader reader) {
    this.position = reader.readInt();
  }

  @Override
  public void write(@NotNull PayloadWriter writer) {
    writer.writeInt(this.position);
  }

  @Override
  public String toString() {
    return "QueuePacket{" +
            "position=" + position +
            '}';
  }
}
