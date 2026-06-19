package de.projektweihnachten.laby.addon2026.packets;

import net.labymod.serverapi.api.packet.Packet;
import net.labymod.serverapi.api.payload.io.PayloadReader;
import net.labymod.serverapi.api.payload.io.PayloadWriter;
import org.jetbrains.annotations.NotNull;
import java.util.List;
import java.util.Objects;

public class RegionPacket implements Packet {
  private int claimpoints;
  private String name;
  private String owner;
  private List<RegionPacketPermsObject> perms;
  private boolean editable;

  public RegionPacket(final int claimpoints, final String name, final String owner, final List<RegionPacketPermsObject> perms, final boolean editable) {

    Objects.requireNonNull(perms, "Objects list cannot be null");
    this.claimpoints = claimpoints;
    this.name = name;
    this.owner = owner;
    this.perms = perms;
    this.editable = editable;
  }

  public boolean isEditable() {
    return editable;
  }

  public int getClaimpoints() {
    return claimpoints;
  }

  public List<RegionPacketPermsObject> getPerms() {
    return perms;
  }

  public String getName() {
    return name;
  }

  public String getOwner() {
    return owner;
  }

  @Override
  public void read(@NotNull PayloadReader reader) {
    this.claimpoints = reader.readInt();
    this.name = reader.readOptionalString();
    this.owner = reader.readOptionalString();
    this.perms = reader.readList(() -> new RegionPacketPermsObject(
        reader.readOptionalString(),
        reader.readOptionalString(),
        reader.readBoolean(),
        reader.readBoolean()
    ));
    this.editable = reader.readBoolean();
  }

  @Override
  public void write(@NotNull PayloadWriter writer) {
    writer.writeInt(this.claimpoints);
    writer.writeOptionalString(this.name);
    writer.writeOptionalString(this.owner);
    writer.writeCollection(this.perms, (perm) -> {
      writer.writeOptionalString(perm.cmd);
      writer.writeOptionalString(perm.name);
      writer.writeBoolean(perm.value);
      writer.writeBoolean(perm.allowed);
    });
    writer.writeBoolean(this.editable);
  }

  @Override
  public String toString() {
    return "RegionPacket{" +
        "claimpoints=" + claimpoints +
        ", name='" + name + '\'' +
        ", owner='" + owner + '\'' +
        ", perms=" + perms +
        ", editable=" + editable +
        '}';
  }

  public record RegionPacketPermsObject(String cmd, String name, boolean value, boolean allowed) {
    @Override
    public @NotNull String toString() {
      return "RegionPacketPermsObject{" +
          "cmd='" + cmd + '\'' +
          ", name='" + name + '\'' +
          ", value=" + value +
          ", allowed=" + allowed +
          '}';
    }
  }
}
