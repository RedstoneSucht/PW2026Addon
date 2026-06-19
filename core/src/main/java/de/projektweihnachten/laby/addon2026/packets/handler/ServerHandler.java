package de.projektweihnachten.laby.addon2026.packets.handler;

import de.projektweihnachten.laby.addon2026.activities.RegionPermission;
import de.projektweihnachten.laby.addon2026.hud.HudDataManager;
import de.projektweihnachten.laby.addon2026.packets.ServerPacket;
import net.labymod.serverapi.api.packet.PacketHandler;
import org.jetbrains.annotations.NotNull;
import java.util.UUID;

public class ServerHandler implements PacketHandler<ServerPacket> {

  @Override
  public void handle(@NotNull UUID sender, @NotNull ServerPacket packet) {
    RegionPermission.setPwserver(true);
    HudDataManager.setOnlineGlobal(packet.getGlobal());
    HudDataManager.setOnlineWorld(packet.getWorld());
    HudDataManager.setOnlineTeam(packet.getTeam());
  }
}
