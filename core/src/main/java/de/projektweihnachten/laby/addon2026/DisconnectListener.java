package de.projektweihnachten.laby.addon2026;

import de.projektweihnachten.laby.addon2026.activities.RegionPermission;
import de.projektweihnachten.laby.addon2026.hud.HudDataManager;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.network.server.ServerDisconnectEvent;
import java.util.List;

public class DisconnectListener {

  @Subscribe
  public void onDisconnect(ServerDisconnectEvent event) {
    HudDataManager.disconnect();
    RegionPermission.setPwserver(false);
    RegionPermission.setEditable(false);
    RegionPermission.setGamemode(false);
    RegionPermission.setGamemodeName(null);
    RegionPermission.setGamemodeUrl(null);
    RegionPermission.setGamemodeInfo(null);
    RegionPermission.setRegion(null, null, List.of(),false);
  }

}
