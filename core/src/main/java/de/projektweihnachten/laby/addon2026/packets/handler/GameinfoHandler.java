package de.projektweihnachten.laby.addon2026.packets.handler;

import de.projektweihnachten.laby.addon2026.activities.RegionPermission;
import de.projektweihnachten.laby.addon2026.packets.GameinfoPacket;
import net.labymod.serverapi.api.packet.PacketHandler;
import org.jetbrains.annotations.NotNull;
import java.util.UUID;

public class GameinfoHandler implements PacketHandler<GameinfoPacket> {

  @Override
  public void handle(@NotNull UUID sender, @NotNull GameinfoPacket packet) {
    RegionPermission.setPwserver(true);
    RegionPermission.setGamemode(packet.isGamemode());
    RegionPermission.setGamemodeUrl(packet.getGamemodeUrl());
    RegionPermission.setGamemodeName(packet.getGamemodeName());
    RegionPermission.setGamemodeInfo(packet.getGamemodeInfo());
  }
}
