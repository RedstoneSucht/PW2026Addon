package de.projektweihnachten.laby.addon2026;

import de.projektweihnachten.laby.addon2026.activities.PW2026NavigationElement;
import de.projektweihnachten.laby.addon2026.hud.HudDataManager;
import de.projektweihnachten.laby.addon2026.hud.widgets.*;
import de.projektweihnachten.laby.addon2026.packets.GameinfoPacket;
import de.projektweihnachten.laby.addon2026.packets.QueuePacket;
import de.projektweihnachten.laby.addon2026.packets.RegionPacket;
import de.projektweihnachten.laby.addon2026.packets.ServerPacket;
import de.projektweihnachten.laby.addon2026.packets.handler.GameinfoHandler;
import de.projektweihnachten.laby.addon2026.packets.handler.QueueHandler;
import de.projektweihnachten.laby.addon2026.packets.handler.RegionHandler;
import de.projektweihnachten.laby.addon2026.packets.handler.ServerHandler;
import net.labymod.api.Laby;
import net.labymod.api.addon.LabyAddon;
import net.labymod.api.client.gui.icon.Icon;
import net.labymod.api.client.resources.ResourceLocation;
import net.labymod.api.models.addon.annotation.AddonMain;
import net.labymod.api.serverapi.LabyModProtocolService;
import net.labymod.serverapi.api.packet.Direction;
import net.labymod.serverapi.core.AddonProtocol;

@AddonMain
public class PW2026Addon extends LabyAddon<PW2026AddonConfig> {

  private final Icon hudIcon = Icon.texture(
          ResourceLocation.create("pw2026", "themes/vanilla/textures/settings/hud/snowflake64.png"))
      .resolution(64, 64);

  private static PW2026Addon instance = null;

  public static PW2026Addon getInstance() {
    return instance;
  }

  private PW2026NavigationElement nav =null;

  public PW2026NavigationElement getNav() {
    return nav;
  }

  @Override
  protected void enable() {
    instance = this;
    this.registerSettingCategory();

    nav = new PW2026NavigationElement(hudIcon);
    this.labyAPI().navigationService().register(nav);

    this.labyAPI().eventBus().registerListener(new DisconnectListener());

    this.labyAPI().hudWidgetRegistry().categoryRegistry().register(HudDataManager.getCategory());

    this.labyAPI().hudWidgetRegistry().register(new ClaimpointsHudWidget("claimpoints", hudIcon));
    this.labyAPI().hudWidgetRegistry().register(new OnlineTeamHudWidget("online_team", hudIcon));
    this.labyAPI().hudWidgetRegistry()
        .register(new OnlineGlobalHudWidget("online_global", hudIcon));
    this.labyAPI().hudWidgetRegistry().register(new OnlineWorldHudWidget("online_world", hudIcon));
    this.labyAPI().hudWidgetRegistry().register(new RegionNameHudWidget("regionname", hudIcon));
    this.labyAPI().hudWidgetRegistry().register(new QueuePositionHudWidget("queue", hudIcon));

    LabyModProtocolService protocolService = Laby.references().labyModProtocolService();

    AddonProtocol protocol = new AddonProtocol(protocolService, "pw2026");

    protocol.registerPacket(0, GameinfoPacket.class, Direction.CLIENTBOUND,new GameinfoHandler());
    protocol.registerPacket(1, RegionPacket.class, Direction.CLIENTBOUND,new RegionHandler());
    protocol.registerPacket(2, ServerPacket.class, Direction.CLIENTBOUND,new ServerHandler());
    protocol.registerPacket(3, QueuePacket.class, Direction.CLIENTBOUND,new QueueHandler());

    protocolService.registry().registerProtocol(protocol);


    this.logger().info("Enabled the Addon");
  }

  @Override
  protected Class<PW2026AddonConfig> configurationClass() {
    return PW2026AddonConfig.class;
  }

}
