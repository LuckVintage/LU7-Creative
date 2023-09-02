<div align='center'>

<img src=https://cdn.luckvintage.com/LU7Logo.jpg alt="logo" width=200 height=200 />

<h1>LU7 Creative</h1>
<p>This is a public version of the custom plugin used on the LU7 Creative Minecraft server.</p>

<h4> <span> · </span> <a href="https://github.com/LuckVintage/LU7-Creative/blob/main/README.md"> Documentation </a> <span> · </span> <a href="https://github.com/LuckVintage/LU7-Creative/issues"> Report Bug </a> <span> · </span> <a href="https://github.com/LuckVintage/LU7-Creative/issues"> Request Feature </a> </h4>


</div>

# :notebook_with_decorative_cover: Table of Contents

- [About the Project](#star2-about-the-project)
- [Contributing](#wave-contributing)
- [License](#warning-license)


## :star2: About the Project

This is a public version of the custom plugin used on the LU7 Creative Minecraft server. It has been adapted slightly for public use. I created this plugin as a way for me to get notifications through [ntfy](https://ntfy.sh/) whenever certain things happened on my Minecraft server. I thought others might find this plugin helpful, so I published an open-source version.

<div align='center'>

<img src=https://cdn.luckvintage.com/02-09-2023_19-40-16_0TBVbX9zv38ccf9w2V.png alt="Example notification screenshot"/>

</div>

### :dart: Features
- Server Start Notifications
- Server Stop Notifications
- Player Join Notifications
- Configure notification preferences in config.yml
- Reload command
- Notification test command

## :toolbox: Getting Started

To install LU7 Creative on your Minecraft server, download the latest release and upload the included JAR file to your Minecraft server plugins folder. Once you've started your server, head to the lu7creative folder and, edit the default config.yml to include your ntfy server and token details, alter the other settings according to your liking. Either restart your entire server or run the /lu7creativereload command. To test that everything is working as intended, you can use the /lu7creativetest <message> command. You should see a test notification appearing in your [ntfy](https://ntfy.sh/) instance. 

### :bangbang: Prerequisites

- A Minecraft Java server running either Paper/Spigot/Bukkit Minecraft versions 1.20 or 1.20.1. We recommend the latest version. The plugin MAY work with other versions; however, this has not been tested.
- An [ntfy](https://ntfy.sh/) server that you have permission to use.
- An [ntfy](https://ntfy.sh/) API token for your instance. We do not support authentication with a username and password.

## :warning: License

Distributed under the GNU General Public License v3.0. See LICENSE.txt for more information.
