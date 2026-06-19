package de.projektweihnachten.laby.addon2026.activities;

import de.projektweihnachten.laby.addon2026.PW2026Addon;
import de.projektweihnachten.laby.addon2026.PW2026AddonConfig;
import net.labymod.api.Laby;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.gui.icon.Icon;
import net.labymod.api.client.gui.navigation.elements.ScreenNavigationElement;

public class PW2026NavigationElement extends ScreenNavigationElement {

  private final Icon snowflake;

  public PW2026NavigationElement(Icon icon) {
    super(new PW2026Activity());
    snowflake = icon;
  }

  @Override
  public Component getDisplayName() {
    return Component.translatable("pw2026.activity.tab");
  }

  @Override
  public Icon getIcon() {
    return snowflake;
  }

  @Override
  public String getWidgetId() {
    return "pw2026-activity-wrapper";
  }

  @Override
  public boolean isVisible() {
    PW2026AddonConfig config = PW2026Addon.getInstance().configuration();
    return config.enabled().getOrDefault(true) && (config.getPermanav().getOrDefault(false) || RegionPermission.isPwserver());
  }

  public void reloadActivity() {
    Laby.labyAPI().minecraft().executeOnRenderThread(new Runnable() {
      @Override
      public void run() {
        ((PW2026Activity) getScreen()).reload();
      }
    });
  }
}
