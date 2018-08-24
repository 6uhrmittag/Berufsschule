# Informieren Sie sich über die Grundlagen der Virtualisierung.
  
## Was ist ein Hypervisor? Welche Aufgaben hat er?
Zwei Typen:
### Typ 1
- direkt auf der Hardware, kontrolliert die Hardware Ressourcen und überwacht die Gastbetriebssysteme
- „VMware vSphere“, „Microsoft Hyper-V“ und der „Xen“ Hypervisor
### Typ 2
- Zwei-Layer-basierten Prozess. Wie eine gewöhnliche Software die auf einem Betriebssystem ausgeführt
- „OSX Parallels“, „VMware Workstation“,  „Oracle VM VirtualBox, QEMU

## b. Wie unterscheiden sich Virtualisierung und Paravirtualisierung?
- Virtualisierung: VM weiß nichts von Virtualisierung. VM-Manager übersetzt VM Zugriffe zu Hypervisor. Also mehrstufig mit Performanceeinbußen. VM-OS braucht keine Anpassung. Hat sicher eher durchgesetzt, da vollständig isoliert von Hypervisor bzw. Hardware.
- Paravirtualisierung: VM kommuniziert direkt mit Hypervisor, VM-OS muss Hypercalls unterstützen.
## Gehen Sie auch auf die Bedeutung von Ring 0 und Ring 3 des Prozessors ein.
- Prozessoren unterscheiden 4 Privilegstufen. Ring 0 bis 4.
- Ring 0: Kernel Mode -> Betriebssystem -> Paravirtualisierung
- Ring 3: User-Mode -> Anwendungen -> Virtualisierung (Hypervisor übersetzt Zugriffe von VM zu Ring 3)

## c. Was steckt hinter den Abkürzungen SDS, SDN und SDC?
"Software Defined" bezeichnet den Dienst jeweils als Abstrakte Ebene, die möglichst wenig von der Hardware abhängig ist. Software defined Storage kann so z.B. unabhängig der Festplattengröße oder dem Standort erweitert werden.
- Software Defined Storage
- Software Defined Networking
- Software Defined Compute
## d. Vergleichen Sie die Verfahren Bare Metal Hypervisor und Hosted Hypervisor.
- Bare Metal Hypervisor
 - Typ 1 Virtualisierung -> es wird kein Host-OS benötigt das Kommunikation übernimmt. Erfordert Unterstüzung durch VM-OS (Treiber)
- Hosted Hypervisor
 - Typ 2 Virtualisierung -> auch "Desktop-Virtualisierung". Benötigt OS, das zusätzliche Wartung erfordert wie ein normales OS.
## e. Welche Ressourcen können Sie in unserem Aufbau virtualisieren?
- SDC

# Planen Sie den Aufbau des Clusters und die benötigten Dienste
