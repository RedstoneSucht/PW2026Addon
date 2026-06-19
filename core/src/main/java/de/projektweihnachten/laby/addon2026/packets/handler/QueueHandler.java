package de.projektweihnachten.laby.addon2026.packets.handler;

import de.projektweihnachten.laby.addon2026.activities.RegionPermission;
import de.projektweihnachten.laby.addon2026.hud.HudDataManager;
import de.projektweihnachten.laby.addon2026.packets.QueuePacket;
import java.util.UUID;
import net.labymod.serverapi.api.packet.PacketHandler;
import org.jetbrains.annotations.NotNull;

public class QueueHandler implements PacketHandler<QueuePacket> {

  @Override
  public void handle(@NotNull UUID sender, @NotNull QueuePacket packet) {
    RegionPermission.setPwserver(true);
    HudDataManager.setQueue(packet.getPosition());
  }
}
