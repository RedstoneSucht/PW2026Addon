package de.projektweihnachten.laby.addon2026.packets.handler;

import com.google.gson.JsonObject;
import de.projektweihnachten.laby.addon2026.PW2026Addon;
import de.projektweihnachten.laby.addon2026.activities.RegionPermission;
import de.projektweihnachten.laby.addon2026.hud.HudDataManager;
import de.projektweihnachten.laby.addon2026.packets.RegionPacket;
import net.labymod.serverapi.api.packet.PacketHandler;
import org.jetbrains.annotations.NotNull;
import java.util.UUID;

public class RegionHandler implements PacketHandler<RegionPacket> {

  @Override
  public void handle(@NotNull UUID sender, @NotNull RegionPacket packet) {
    RegionPermission.setPwserver(true);
    HudDataManager.setClaimPoints(packet.getClaimpoints());
    RegionPermission.setRegion(packet.getName(), packet.getOwner(), packet.getPerms(), packet.isEditable());
    HudDataManager.setRegionName(RegionPermission.getRegionName());
    PW2026Addon.getInstance().getNav().reloadActivity();
  }
}
