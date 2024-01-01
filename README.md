<div align='center'>

<img src=https://cdn.luckvintage.com/LU7Logo.jpg alt="logo" width=200 height=200 />

<h1>LU7 Creative</h1>
<p>This is a public version of the custom plugin used on the LU7 Creative Minecraft server.</p>

<h4> <span> · </span> <a href="https://github.com/LuckVintage/LU7-Creative/blob/main/README.md"> Documentation </a> <span> · </span> <a href="https://github.com/LuckVintage/LU7-Creative/issues"> Report Bug </a> <span> · </span> <a href="https://github.com/LuckVintage/LU7-Creative/issues"> Request Feature </a> <span> · </span> <a href="https://bstats.org/plugin/bukkit/LU7%20Creative/20562"> bStats </a> </h4>


</div>

# :notebook_with_decorative_cover: Table of Contents

- [Download](#link-download)
- [About the Project](#star2-about-the-project)
- [Getting Started](#toolbox-getting-started)
- [Prerequisites](#bangbang-prerequisites)
- [License](#warning-license)


## :link: DOWNLOAD

- Github: https://github.com/LuckVintage/LU7-Creative/releases/download/3.0-SNAPSHOT/lu7creative-3.0-SNAPSHOT.jar
- SpigotMC: https://www.spigotmc.org/resources/lu7-creative.112440/
- Modrinth: https://modrinth.com/plugin/lu7-creative

## :star2: About the Project

This is a public version of the custom plugin used on the LU7 Creative Minecraft server. It has been adapted slightly for public use. I created this plugin as a way for me to get notifications through [ntfy](https://ntfy.sh/) whenever certain things happened on my Minecraft server. I thought others might find this plugin helpful, so I published an open-source version.

### :dart: Features
- Server Start Notifications
- Server Stop Notifications
- Player Join Notifications
- Player Leave Notifications
- Update Available Notifications
- Player notification bypass permission
- Configure notification preferences in config.yml
- Reload command
- Notification test command
- Automatic update checker

<div align='center'>

<img src=https://cdn.luckvintage.com/LU7-Creative-Plugin-Screenshot.png alt="Example notification screenshot"/>

</div>

## :toolbox: Getting Started

To install LU7 Creative on your Minecraft server, download the latest release and upload the included JAR file to your Minecraft server plugins folder. Once you've started your server, head to the lu7creative folder and, edit the default config.yml to include your ntfy server and token details, alter the other settings according to your liking. Either restart your entire server or run the /lu7creativereload command. To test that everything is working as intended, you can use the /lu7creativetest <message> command. You should see a test notification appearing in your [ntfy](https://ntfy.sh/) instance. You will not receive join or leave notifications for players with the permission `lu7creative.presencebypasss` set to false.  

### :bangbang: Prerequisites

- A Minecraft Java server running either Paper/Spigot/Bukkit Minecraft versions 1.20 or 1.20.1. We recommend the latest version. The plugin MAY work with other versions; however, this has not been tested.
- An [ntfy](https://ntfy.sh/) server that you have permission to use.
- An [ntfy](https://ntfy.sh/) API token for your instance. We do not support authentication with a username and password.

## :warning: License

Distributed under the GNU General Public License v3.0. See LICENSE.txt for more information.
