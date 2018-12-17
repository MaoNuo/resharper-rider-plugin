$PSScriptRoot = Split-Path $MyInvocation.MyCommand.Path -Parent
$PluginId = "ReSharperPlugin.SamplePlugin"
$SolutionPath = "$PSScriptRoot\SamplePlugin.sln"
$SourceBasePath = "$PSScriptRoot\src\dotnet"

$VisualStudioBaseDirectory = & "$PSScriptRoot\tools\vswhere.exe" "-latest" "-property" "installationPath"
$DevEnvPath = Get-ChildItem "$VisualStudioBaseDirectory\Common7\IDE\devenv.exe"
$MSBuildPath = Get-ChildItem "$VisualStudioBaseDirectory\MSBuild\15.0\Bin\MSBuild.exe"

$OutputDirectory = "$PSScriptRoot\output"
$NuGetPath = "$PSScriptRoot\tools\nuget.exe"

Function Invoke-Exe {
    param(
        [parameter(mandatory=$true,position=0)] [ValidateNotNullOrEmpty()] [string] $Executable,
        [Parameter(ValueFromRemainingArguments=$true)][String[]] $Arguments,
        [parameter(mandatory=$false)] [array] $ValidExitCodes = @(0)
    )

    Write-Host "> $Executable $Arguments"
    $rc = Start-Process -FilePath $Executable -ArgumentList $Arguments -NoNewWindow -Wait -Passthru
    if (-Not $ValidExitCodes.Contains($rc.ExitCode)) {
        throw "'$Executable $Arguments' failed with exit code $($rc.ExitCode), valid exit codes: $ValidExitCodes"
    }
}